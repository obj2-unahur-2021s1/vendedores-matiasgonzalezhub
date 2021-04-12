package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.kotest.matchers.types.shouldBeSameInstanceAs

class CentroDistribucionTest : DescribeSpec({
  val misiones = Provincia(1300000)
  val sanIgnacio = Ciudad(misiones)

  val cordoba = Provincia(1000000)
  var rioCuarto = Ciudad(cordoba)

  describe("Vendedor fijo centro") {
    val obera = Ciudad(misiones)
    val vendedorFijo = VendedorFijo(obera)
    val centroDistribucion = CentroDistribucion(obera)
    var vendedorFijoCordoba = VendedorFijo(rioCuarto)

    describe("puedeTrabajarEn") {

      it("agregar vendedor") {
        println(centroDistribucion.vendedores.size.toString())
        centroDistribucion.agregarVendedor(vendedorFijoCordoba)
        centroDistribucion.vendedores.count().shouldBe(1)
      }


    //  it("agregar vendedor existente") {
    //      centroDistribucion.agregarVendedor(vendedorFijo)
    //  }

      it("vendedor Estrella"){
        centroDistribucion.vendedorEstrella()
      }

      it("puede Cubrir"){
        centroDistribucion.puedeCubrir(obera).shouldBeFalse()
      }

      it("vendedores Genericos"){
        centroDistribucion.vendedoresGenericos().count().shouldBe(0)
      }

      it("es Robusto"){
        centroDistribucion.esRobusto().shouldBeFalse()
      }

    }
  }




})
