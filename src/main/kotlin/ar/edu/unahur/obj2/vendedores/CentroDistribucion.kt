package ar.edu.unahur.obj2.vendedores

class CentroDistribucion (val ciudad: Ciudad){

    val vendedores = mutableListOf<Vendedor>()

    //devuelve nada
    fun agregarVendedor(vendedor : Vendedor){

        check(vendedores.contains(vendedor)) {
            "Vendedor ya existente"
        }
        vendedores.add(vendedor)
    }

    //devuelve Vendedor
    fun vendedorEstrella() : Vendedor? {
      return   vendedores.maxBy { c -> c.puntajeCertificaciones() }
    }

    //devuelve Boolean
    fun puedeCubrir(ciudad : Ciudad) : Boolean{
        return vendedores.any { i -> i.puedeTrabajarEn(ciudad) }
    }

    //devuelve lista de vendedores
    fun vendedoresGenericos() : List<Vendedor>
    {
       // return vendedores.filter { c -> c.otrasCertificaciones() == 1 }
        return vendedores.filter { i -> i.esGenerico() }
    }

    //devuelve Boolean
    fun esRobusto() : Boolean {

      //  var vendedoresFirmes: MutableList<Vendedor> = vendedores.filter { c: Vendedor -> c.esFirme() }.toMutableList()
//
      //  return vendedoresFirmes.size >= 3

        return vendedores.count{ i -> i.esFirme()} >= 3
    }
}