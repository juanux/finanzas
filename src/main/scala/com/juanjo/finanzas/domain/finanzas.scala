package com.juanjo.finanzas.domain

import java.util.UUID

import com.juanjo.finanzas.infrastructure.http.dto.{CategoryDTO, MoveDTO, MoveTypeDTO}

class MoveType(code:String, name:String)

case class MoveCategory(code:String, name:String,moveType:MoveType)

case class Move(id:UUID,name:String,category:, month: Int, Year:Int, amount:Int )

object MoveType{
  def apply(code:String, name:String):MoveType  = {
    MoveType(code, name)
  }

  def fromDTO(dto:MoveTypeDTO):Either[DomainError,MoveType] = {

    dto.code match{
      case Some(code) =>{
        if(code.isEmpty) Left(InvalidMoveType)
        else if(code.nonEmpty && dto.name.nonEmpty) Right(MoveType(code,dto.name))
        else Left(InvalidMoveType)
      }
      case None => {
        if (dto.name.nonEmpty) Left(InvalidMoveType)
        else Right(MoveType(UUID.randomUUID().toString,dto.name))
      }

    }

  }
}

object MoveCategory{
  def apply(code:String, name:String):MoveCategory  = {
    MoveCategory(code, name)
  }

  def fromDTO(dto:CategoryDTO):Either[DomainError,MoveCategory] = {

    dto.code match{
      case Some(code) =>{
        if(code.isEmpty) Left(InvalidMoveType)
        else if(code.nonEmpty && dto.name.nonEmpty) Right(MoveCategory(code,dto.name))
        else Left(InvalidCategory)
      }
      case None => {
        if (dto.name.nonEmpty) Left(InvalidMoveType)
        else Right(MoveCategory(UUID.randomUUID().toString,dto.name))
      }

    }

  }
}

object Move{
  def apply(code:String, name:String):Move  = {
    Move(code, name)
  }

  def fromDTO(dto:MoveDTO):Either[DomainError,Move] = {

    dto.id match{
      case Some(code) =>{
        Left(InvalidMove)
      }
      case None => {
       if(dto.category.nonEmpty && dto.name.nonEmpty && dto.amount > 0 && dto.year > 0 && dto.month > 0) Right(Move(UUID.randomUUID(),dto.name,dto.category, dto.month, dto.year,dto.amount))
       else  Left(InvalidMove)
      }

    }

  }
}