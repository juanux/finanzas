package com.juanjo.finanzas.infrastructure.http.dto

case class MoveTypeDTO(code:Option[String], name:String)
case class CategoryDTO(code:Option[String], name:String,moveType:String)
case class MoveDTO(id:Option[String],name:String,category:String, month: Int, year:Int,amount:Int )

