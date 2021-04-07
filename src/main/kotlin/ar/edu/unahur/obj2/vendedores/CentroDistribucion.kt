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
}