package ar.edu.unahur.obj2.vendedores

class CentroDistribucion (val ciudad: Ciudad){

    val vendedores = mutableListOf<Vendedor>()

    fun agregarVendedor(vendedor : Vendedor){
        vendedores.add(vendedor)
    }

    fun vendedorEstrella() : Vendedor? {
      return   vendedores.maxBy { c -> c.puntajeCertificaciones() }
    }

    fun puedeCubrir(ciudad : Ciudad) : Boolean{
        return vendedores.any { i -> i.puedeTrabajarEn(ciudad) }
    }

    fun vendedoresGenericos() : List<Vendedor>
    {
        return vendedores.filter { c -> c.otrasCertificaciones() == 1 }
    }

    fun esRobusto() : Boolean {

        var vendedoresFirmes = mutableListOf<Vendedor>()

        vendedoresFirmes = vendedores.filter { c: Vendedor -> c.esFirme() }.toMutableList()

        return vendedoresFirmes.size >= 3
    }
}