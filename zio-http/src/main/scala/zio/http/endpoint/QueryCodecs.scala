package zio.http.endpoint

import zio.http.endpoint.internal.TextCodec
import zio.stacktracer.TracingImplicits.disableAutoTrace // scalafix:ok;

private[endpoint] trait QueryCodecs {
  def query(name: String): QueryCodec[String] =
    HttpCodec.Query(name, TextCodec.string)

  def queryBool(name: String): QueryCodec[Boolean] =
    HttpCodec.Query(name, TextCodec.boolean)

  def queryInt(name: String): QueryCodec[Int] =
    HttpCodec.Query(name, TextCodec.int)

  def queryAs[A](name: String)(implicit codec: TextCodec[A]): QueryCodec[A] =
    HttpCodec.Query(name, codec)
}