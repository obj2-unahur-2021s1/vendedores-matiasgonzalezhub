package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class CentroDistribucionTest : DescribeSpec({
  val misiones = Provincia(1300000)
  val sanIgnacio = Ciudad(misiones)

  describe("Vendedor fijo centro") {
    val obera = Ciudad(misiones)
    val vendedorFijo = VendedorFijo(obera)
    val centroDistribucion = CentroDistribucion(obera)

    describe("puedeTrabajarEn") {

      it("agregar vendedor") {
        centroDistribucion.agregarVendedor(vendedorFijo)
      }

      it("vendedorEstrella"){
        centroDistribucion.vendedorEstrella()
      }

      it("puede Cubrir"){
        centroDistribucion.puedeCubrir(obera).shouldBeTrue()
      }

      it("vendedores Genericos"){
        centroDistribucion.vendedoresGenericos().count()==1
      }

      it("es Robusto"){
        centroDistribucion.esRobusto().shouldBeFalse()
      }

    }
  }




})
