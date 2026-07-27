<details><summary>点击展开</summary><pre>package com.adskipper.cleaner

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import java.util.regex.Pattern

class AdSkipService : AccessibilityService() {
private val whiteList = setOf("com.tencent.mm", "com.icbc", "com.chinamworld", "com.google.android")
override fun onAccessibilityEvent(event: AccessibilityEvent?) {
if (event?.eventType != AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) return
val root = rootInActiveWindow ?: return
val pkg = event.packageName?.toString() ?: return
if (whiteList.any { pkg.startsWith(it) }) return
// ID匹配
val idKeywords = arrayOf("skip", "close", "cancel", "dislike", "ttad", "gdt")
for (id in idKeywords) {
val nodes = root.findAccessibilityNodeInfosByViewId(".$id.")
if (nodes.isNotEmpty() && nodes[0].isClickable) {
nodes[0].performAction(AccessibilityNodeInfo.ACTION_CLICK)
nodes.forEach { it.recycle() }
return
}
}
// 文本匹配
val pattern = Pattern.compile("跳过关闭")
