package ar.edu.unahur.obj2.vendedores

class CentroDistribucion (val vendedores: mutableListOf<Vendedor> , val ciudad : Ciudad ) {

// metodo que no devuelve nada
    fun agregarVendedor( vendedor : Vendedor)
    {
        check(vendedores.contains(vendedor)) {
            "Vendedor ya existente"
        }

        vendedores.add(vendedor)

    }

    //devuelve vendedor
    fun vendedorEstrella() : Vendedor
    {
        return vendedores.maxBy(this.puntajeCertificaciones())
    }

    //devuelve bool
    fun puedeCubrirCiudad(ciudad : Ciudad) : Boolean
    {
        return vendedores.any( i -> i.puedeTrabajarEn(ciudad))
    }

    fun vendedoresGenericos() : mutableListOf<Vendedor>
    {
        return vendedores.filter( i -> i.otrasCertificaciones())
    }

    fun robusto() : Boolean
    {
        return vendedores.filter( i -> esFirme()).size > 3
    }
}