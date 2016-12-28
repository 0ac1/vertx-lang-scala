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

package io.vertx.scala.core.shareddata

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.shareddata.{Counter => JCounter}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * An asynchronous counter that can be used to across the cluster to maintain a consistent count.
  * 
  */
class Counter(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
  def get(resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].get({x: AsyncResult[java.lang.Long] => resultHandler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
  }

  def incrementAndGet(resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].incrementAndGet({x: AsyncResult[java.lang.Long] => resultHandler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
  }

  def getAndIncrement(resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].getAndIncrement({x: AsyncResult[java.lang.Long] => resultHandler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
  }

  def decrementAndGet(resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].decrementAndGet({x: AsyncResult[java.lang.Long] => resultHandler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
  }

  def addAndGet(value: Long,resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].addAndGet(value.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.Long] => resultHandler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
  }

  def getAndAdd(value: Long,resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].getAndAdd(value.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.Long] => resultHandler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
  }

  def compareAndSet(expected: Long,value: Long,resultHandler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JCounter].compareAndSet(expected.asInstanceOf[java.lang.Long],value.asInstanceOf[java.lang.Long],{x: AsyncResult[java.lang.Boolean] => resultHandler.handle(AsyncResultWrapper[java.lang.Boolean,Boolean](x, a => a.asInstanceOf[Boolean]))})
  }

//future methods
def getFuture():scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JCounter].get(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def incrementAndGetFuture():scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JCounter].incrementAndGet(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def getAndIncrementFuture():scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JCounter].getAndIncrement(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def decrementAndGetFuture():scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JCounter].decrementAndGet(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def addAndGetFuture(value: Long):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JCounter].addAndGet(value.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def getAndAddFuture(value: Long):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JCounter].getAndAdd(value.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def compareAndSetFuture(expected: Long,value: Long):scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JCounter].compareAndSet(expected.asInstanceOf[java.lang.Long],value.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object Counter{
    def apply(asJava: JCounter) = new Counter(asJava)  
  //static methods
  }
