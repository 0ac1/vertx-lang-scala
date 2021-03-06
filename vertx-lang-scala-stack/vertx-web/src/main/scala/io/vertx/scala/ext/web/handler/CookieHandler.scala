/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.ext.web.handler

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.web.handler.{CookieHandler => JCookieHandler}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler

/**
  * A handler which decodes cookies from the request, makes them available in the 
  * and writes them back in the response.
  */
class CookieHandler(private val _asJava: Object)
    extends io.vertx.core.Handler[RoutingContext] {

  def asJava = _asJava


  override def handle(arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JCookieHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object CookieHandler {
  def apply(asJava: JCookieHandler) = new CookieHandler(asJava)  
  /**
    * Create a cookie handler
    * @return the cookie handler
    */
  def create(): CookieHandler = {
    CookieHandler(JCookieHandler.create())
  }

}
