package com.juanjo.finanzas.domain

trait DomainError

case class Error(code:String = "01", message:String = "General error") extends DomainError

case object InvalidMoveType extends Error {
 override def code = "02"
  override def message = "Tipo de movimiento invalido"
}


case object InvalidCategory extends Error {
  override def code = "03"
  override def message = "Categoria inválido"
}

case object InvalidMove extends Error {
  override def code = "03"
  override def message = "Movimiento inválido"
}


