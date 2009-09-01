package com.googlecode.html2blog

import java.io.{FileReader, File}
import java.util.Properties
import org.webfabric.io.{Url}

object Main {
  def main(args: Array[String]) {
    val properties = new Properties(System.getProperties)
    val filename = "html2blog.properties"
    if (new File(filename).exists()) {
      properties.load(new FileReader(filename))
    }
    val publisher = new Publisher(properties)
    val postUrl = publisher.publish(System.in)
    System.out.println(postUrl)
  }
}