package ar.edu.unahur.obj2.vendedores

class Certificacion(val esDeProducto: Boolean, val puntaje: Int)

abstract class Vendedor {
  // Acá es obligatorio poner el tipo de la lista, porque como está vacía no lo puede inferir.
  // Además, a una MutableList se le pueden agregar elementos
  val certificaciones = mutableListOf<Certificacion>()

  // Definimos el método abstracto.
  // Como no vamos a implementarlo acá, es necesario explicitar qué devuelve.
  abstract fun puedeTrabajarEn(ciudad: Ciudad): Boolean

  // En las funciones declaradas con = no es necesario explicitar el tipo
  fun esVersatil() =
    certificaciones.size >= 3
      && this.certificacionesDeProducto() >= 1
      && this.otrasCertificaciones() >= 1

  // Si el tipo no está declarado y la función no devuelve nada, se asume Unit (es decir, vacío)
  fun agregarCertificacion(certificacion: Certificacion) {
    certificaciones.add(certificacion)
  }

  // devuelve bool
  fun esFirme() = this.puntajeCertificaciones() >= 30

  //devuelve int
  fun certificacionesDeProducto() = certificaciones.count { it.esDeProducto }

  //devuelve int
  fun otrasCertificaciones() : Int = certificaciones.count { !it.esDeProducto }

  // devuelve int
  fun puntajeCertificaciones() : Int = certificaciones.sumBy { c -> c.puntaje }

  // devuelve bool, no se implementa aca
  abstract fun esInfluyente(): Boolean
}

// En los parámetros, es obligatorio poner el tipo
class VendedorFijo(val ciudadOrigen: Ciudad) : Vendedor() {

  //devuelve bool
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return ciudad == ciudadOrigen
  }

  // devuelve bool
  override fun esInfluyente(): Boolean { return false }

}

// A este tipo de List no se le pueden agregar elementos una vez definida
class Viajante(val provinciasHabilitadas: mutableListOf<Provincia>) : Vendedor() {

  //devuelve bool
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return provinciasHabilitadas.contains(ciudad.provincia)
  }

  //devuelve bool
  override fun esInfluyente(): Boolean { return provinciasHabilitadas.sumBy { p -> p.poblacion} >= 10000000 }

}

class ComercioCorresponsal(val ciudades: mutableListOf<Ciudad>) : Vendedor() {

  //devuelve bool
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return ciudades.contains(ciudad)
  }

  //devuelve bool
  override fun esInfluyente(): Boolean {
   return ciudades.size > 5 || tieneMinimoTresProvincias() > 3

    //debe tener sucursales en al menos 5 ciudades,
  // o bien en al menos 3 provincias considerando la provincia de cada ciudad donde tiene sucursal.
  }

  //devuelve int
  fun tieneMinimoTresProvincias(): Int
  {
    var TieneCiudades: mutableListOf<Ciudad>

    for (ciudade in ciudades) {
      if ( !TieneCiudades.contains(ciudade) )
      {
        TieneCiudades.add(ciudade)
      }
    }

    return TieneCiudades.size
  }
}
