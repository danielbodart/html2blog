package com.googlecode.html2blog

import java.net.URL
import redstone.xmlrpc.XmlRpcProxy

case class Server(url: URL, credentials: Credentials) {
  val metaWeblog: metaWeblog = XmlRpcProxy.createProxy(url, Array[Class[_]](classOf[metaWeblog]), false).asInstanceOf[metaWeblog]

  def createDraft(content: Content): String = {
    val postId: String = metaWeblog.newPost(0, credentials.user, credentials.password, content, false)
    val map = metaWeblog.getPost(postId, credentials.user, credentials.password)
    return map.get("link")
  }
}