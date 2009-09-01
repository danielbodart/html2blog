package com.googlecode.html2blog

trait metaWeblog {
  def newPost(blogId:Int, username:String, password:String, post:java.util.Map[String,String], publish:Boolean): String
  def getPost (postid:String, username:String, password:String):java.util.Map[String,String]
}