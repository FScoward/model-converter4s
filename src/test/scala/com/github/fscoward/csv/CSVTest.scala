package com.github.fscoward.csv

import org.junit.Test
import org.junit.Assert._

class CSVTest {

//  @Test def headerToCsv() = {
//    val header = Header(List("header1, header2, header3"))
//    assertEquals("header1, header2, header3", header.toString)
//  }

  @Test def headerToString(): Unit = {
    assertEquals("header1, header2, header3", CSV(Some(Header(List("header1", "header2", "header3")))).headerToString)
  }

  @Test def rowToString(): Unit = {
    assertEquals("cell1, cell2, cell3", CSV(rows = List(Row(List(Cell("cell1"), Cell("cell2"), Cell("cell3"))))).rowsToString)
  }

  @Test def multipleRowToString(): Unit = {
    assertEquals("cell1, cell2, cell3\ncell4, cell5, cell6",
      CSV(
        rows = List(
          Row(List(Cell("cell1"), Cell("cell2"), Cell("cell3"))),
        Row(List(Cell("cell4"), Cell("cell5"), Cell("cell6"))))).rowsToString)
  }
  // TODO: 複数行

  //  @Test def csvPrinter = {
  //    val csv = CSV(
  //      Some(Header(List("header1, header2, header3"))),
  //      List(
  //        Row(List(Cell("cell1"), Cell("cell2"), Cell("cell3")))
  //        )
  //      )
  //    assertEquals("header1, header2, header3\nrow1, row2, row3", csv.toString)
  //  }
  // todo: ヘッダの数とRowの数が合わなければエラーを出すこと
}


