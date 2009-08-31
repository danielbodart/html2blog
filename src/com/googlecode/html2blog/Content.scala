package com.googlecode.html2blog


case class Content(title:String, body:String)

object Content {
  implicit def toMap(content: Content): java.util.Map[String,String] = {
    val map = new java.util.HashMap[String, String]
    map.put("title", content.title)
    map.put("description", content.body)
    return map
  }
}
