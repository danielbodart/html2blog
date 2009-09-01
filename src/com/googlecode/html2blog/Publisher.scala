package com.googlecode.html2blog

import java.io.InputStream
import java.net.URL
import java.util.Properties
import org.webfabric.sitemesh.DivCapturingPageParser
import opensymphony.module.sitemesh.HTMLPage
import org.webfabric.io.Converter

class Publisher(properties:Properties){
  val url: URL = new URL(properties.getProperty("url"))
  val credentials: Credentials = Credentials(properties.getProperty("user"), properties.getProperty("password"))

  def publish(input:InputStream): String = {
    val server = Server(url, credentials)
    val content = parse(input)
    server.createDraft(content)
  }

  def parse(input:InputStream):Content ={
    val parser = new DivCapturingPageParser
    val page: HTMLPage = parser.parse(Converter.asString(input))
    Content(page.getTitle, page.getBody)
  }

}