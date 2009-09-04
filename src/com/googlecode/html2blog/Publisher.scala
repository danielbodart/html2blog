package com.googlecode.html2blog

import java.io.InputStream
import java.net.URL
import java.nio.CharBuffer
import java.util.Properties
import org.sitemesh.content.tagrules.html.CoreHtmlTagRuleBundle
import org.sitemesh.content.tagrules.TagBasedContentProcessor
import org.sitemesh.content.{ContentProperty}
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
    val parser = new TagBasedContentProcessor(new CoreHtmlTagRuleBundle())
    val buffer: CharBuffer = CharBuffer.wrap(Converter.asString(input))
    val property: ContentProperty = parser.build(buffer, null).getExtractedProperties()
    Content(property.getChild("title").getValue, property.getChild("body").getValue)
  }
}