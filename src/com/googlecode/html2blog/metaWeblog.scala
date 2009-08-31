package com.googlecode.html2blog

trait metaWeblog {
  def newPost(blogId:Int, user:String, password:String, post:java.util.Map[String,String], publish:Boolean): String
}