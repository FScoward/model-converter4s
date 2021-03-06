package com.github.fscoward.csv

case class CSV(header: Option[Header] = None, rows: List[Row] = Nil) {
  private[csv] def headerToString: String = header.map(_.toString).getOrElse("")
  private[csv] def rowsToString: String = {
    @scala.annotation.tailrec
    def loop(rows: List[Row], res: String = ""): String= {
      rows match {
        case Nil => res
        case (head::Nil) => res + head.toString
        case (head::tail) => loop(tail, res + head.toString + "\n")
      }
    }
    loop(rows)
  }
}


case class Header(headers: List[String]) {
  override def toString: String = headers.mkString(", ")
}

case class Row(cells: List[Cell]) {
  override def toString: String = cells.map(_.value).mkString(", ")
}

case class Cell(value: String)

/*
import scala.collection.mutable.ArrayBuffer
object Main {
  class Row {
    val cells = new ArrayBuffer[String]
    def add(cell: String): Unit = cells += cell
    override def toString = cells.mkString("  [", ", ", "]\n")
  }
  class Table {
    val rows = new ArrayBuffer[Row]
    def add(r: Row): Unit = rows += r
    override def toString = rows.mkString("[\n", "", "]")
  }
  def table(init: implicit Table => Unit): Table = {
    implicit val t = new Table
    init
    t
  }
  def row(init: implicit Row => Unit): implicit Table => Unit = {
    implicit val r = new Row
    implicitly[Table].add(r)
    init
    r
  }
  def cell(value: String): implicit Row => Unit = {
    implicitly[Row].add(value)
  }

  def main(args: Array[String]): Unit = {
    val t = table {
      row {
        cell("A")
        cell("B")
        cell("C")
      }
      row {
        cell("1")
        cell("2")
        cell("3")
      }
    }
    println(t)
  }
}
 */