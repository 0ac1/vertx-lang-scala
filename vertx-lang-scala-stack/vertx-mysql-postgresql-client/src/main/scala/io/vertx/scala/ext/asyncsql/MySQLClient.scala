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

package io.vertx.scala.ext.asyncsql

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.scala.ext.sql.SQLConnection
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.sql.{SQLOperations => JSQLOperations}
import io.vertx.scala.ext.sql.ResultSet
import io.vertx.ext.sql.{UpdateResult => JUpdateResult}
import io.vertx.ext.asyncsql.{AsyncSQLClient => JAsyncSQLClient}
import io.vertx.scala.core.Vertx
import io.vertx.ext.sql.{SQLConnection => JSQLConnection}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.core.json.JsonArray
import io.vertx.ext.sql.{ResultSet => JResultSet}
import io.vertx.scala.ext.sql.SQLOperations
import io.vertx.ext.asyncsql.{MySQLClient => JMySQLClient}
import io.vertx.ext.sql.{SQLClient => JSQLClient}
import io.vertx.scala.ext.sql.UpdateResult
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.ext.sql.SQLClient

/**
  * Represents an asynchronous MySQL client
  */
class MySQLClient(private val _asJava: Object)
    extends AsyncSQLClient(_asJava)   {



  override def querySingle(sql: String, handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]): SQLOperations = {
    asJava.asInstanceOf[JMySQLClient].querySingle(sql.asInstanceOf[java.lang.String], {x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray, io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  override def querySingleWithParams(sql: String, arguments: io.vertx.core.json.JsonArray, handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]): SQLOperations = {
    asJava.asInstanceOf[JMySQLClient].querySingleWithParams(sql.asInstanceOf[java.lang.String], arguments, {x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray, io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  override def querySingleFuture(sql: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JMySQLClient].querySingle(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def querySingleWithParamsFuture(sql: String, arguments: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JMySQLClient].querySingleWithParams(sql.asInstanceOf[java.lang.String], arguments, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object MySQLClient {
  def apply(asJava: JMySQLClient) = new MySQLClient(asJava)  
  /**
    * Create a MySQL client which maintains its own pool.
    * @param vertx the Vert.x instance
    * @param config the configuration
    * @return the client
    */
  def createNonShared(vertx: Vertx, config: io.vertx.core.json.JsonObject): AsyncSQLClient = {
    AsyncSQLClient(JMySQLClient.createNonShared(vertx.asJava.asInstanceOf[JVertx], config))
  }

  /**
    * Create a MySQL client which shares its data source with any other MySQL clients created with the same
    * data source name
    * @param vertx the Vert.x instance
    * @param config the configuration
    * @param poolName the pool name
    * @return the client
    */
  def createShared(vertx: Vertx, config: io.vertx.core.json.JsonObject, poolName: String): AsyncSQLClient = {
    AsyncSQLClient(JMySQLClient.createShared(vertx.asJava.asInstanceOf[JVertx], config, poolName.asInstanceOf[java.lang.String]))
  }

  /**
    * Like [[io.vertx.scala.ext.asyncsql.MySQLClient#createShared]] but with the default pool name
    * @param vertx the Vert.x instance
    * @param config the configuration
    * @return the client
    */
  def createShared(vertx: Vertx, config: io.vertx.core.json.JsonObject): AsyncSQLClient = {
    AsyncSQLClient(JMySQLClient.createShared(vertx.asJava.asInstanceOf[JVertx], config))
  }

}
