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

package io.vertx.scala.ext.shell

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.shell.term.{TermServer => JTermServer}
import io.vertx.ext.shell.{ShellServer => JShellServer}
import io.vertx.ext.shell.{Shell => JShell}
import io.vertx.scala.ext.shell.term.Term
import io.vertx.scala.core.Vertx
import io.vertx.ext.shell.{ShellServerOptions => JShellServerOptions}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.ext.shell.command.{CommandResolver => JCommandResolver}
import io.vertx.scala.ext.shell.command.CommandResolver
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.shell.term.{Term => JTerm}
import io.vertx.scala.ext.shell.term.TermServer

/**
  * The shell server.<p/>
  *
  * A shell server is associated with a collection of : the [[io.vertx.scala.ext.shell.ShellServer#registerTermServer]]
  * method registers a term server. Term servers life cycle are managed by this server.<p/>
  *
  * When a  receives an incoming connection, a  instance is created and
  * associated with this connection.<p/>
  *
  * The [[io.vertx.scala.ext.shell.ShellServer#createShell]] method can be used to create  instance for testing purposes.
  */
class ShellServer(private val _asJava: Object) {

  def asJava = _asJava


  /**
    * Register a command resolver for this server.
    * @param resolver the resolver
    * @return a reference to this, so the API can be used fluently
    */
  def registerCommandResolver(resolver: CommandResolver): ShellServer = {
    asJava.asInstanceOf[JShellServer].registerCommandResolver(resolver.asJava.asInstanceOf[JCommandResolver])
    this
  }

  /**
    * Register a term server to this shell server, the term server lifecycle methods are managed by this shell server.
    * @param termServer the term server to add
    * @return a reference to this, so the API can be used fluently
    */
  def registerTermServer(termServer: TermServer): ShellServer = {
    asJava.asInstanceOf[JShellServer].registerTermServer(termServer.asJava.asInstanceOf[JTermServer])
    this
  }

  /**
    * Start the shell service, this is an asynchronous start.
    */
  def listen(): ShellServer = {
    asJava.asInstanceOf[JShellServer].listen()
    this
  }

  /**
    * Start the shell service, this is an asynchronous start.
    * @param listenHandler handler for getting notified when service is started
    */
  def listen(listenHandler: Handler[AsyncResult[Unit]]): ShellServer = {
    asJava.asInstanceOf[JShellServer].listen({x: AsyncResult[Void] => listenHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Close the shell server, this is an asynchronous close.
    */
  def close(): Unit = {
    asJava.asInstanceOf[JShellServer].close()
  }

  /**
    * Create a new shell, the returned shell should be closed explicitely.
    * @param term the shell associated terminal
    * @return the created shell
    */
  def createShell(term: Term): Shell = {
    Shell(asJava.asInstanceOf[JShellServer].createShell(term.asJava.asInstanceOf[JTerm]))
  }

  /**
    * Create a new shell, the returned shell should be closed explicitely.
    * @return the created shell
    */
  def createShell(): Shell = {
    Shell(asJava.asInstanceOf[JShellServer].createShell())
  }

  /**
    * Close the shell server, this is an asynchronous close.
    * @param completionHandler handler for getting notified when service is stopped
    */
  def close(completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JShellServer].close({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JShellServer].listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def closeFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JShellServer].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object ShellServer {
  def apply(asJava: JShellServer) = new ShellServer(asJava)  
  /**
    * Create a new shell server with default options.
    * @param vertx the vertx
    * @param options the optionssee <a href="../../../../../../../cheatsheet/ShellServerOptions.html">ShellServerOptions</a>
    * @return the created shell server
    */
  def create(vertx: Vertx, options: ShellServerOptions): ShellServer = {
    ShellServer(JShellServer.create(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  /**
    * Create a new shell server with specific options.
    * @param vertx the vertx
    * @return the created shell server
    */
  def create(vertx: Vertx): ShellServer = {
    ShellServer(JShellServer.create(vertx.asJava.asInstanceOf[JVertx]))
  }

}
