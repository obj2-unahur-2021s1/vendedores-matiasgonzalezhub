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

  //devuelve Boolean
  fun esFirme() = this.puntajeCertificaciones() >= 30

  //devuelve Int
  fun certificacionesDeProducto() = certificaciones.count { it.esDeProducto }

  //devuelve Int
  fun otrasCertificaciones() = certificaciones.count { !it.esDeProducto }

  //devuelve Int
  fun puntajeCertificaciones() = certificaciones.sumBy { c -> c.puntaje }

  //devuelve Boolean quien la implemente
  abstract fun esInfluyente(): Boolean
}

// En los parámetros, es obligatorio poner el tipo
class VendedorFijo(val ciudadOrigen: Ciudad) : Vendedor() {

  //devuelve Boolean
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return ciudad == ciudadOrigen
  }

  //devuelve Boolean
  override fun esInfluyente(): Boolean
  { return false }
}

// A este tipo de List no se le pueden agregar elementos una vez definida
class Viajante(val provinciasHabilitadas: List<Provincia>) : Vendedor() {

  //devuelve Boolean
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return provinciasHabilitadas.contains(ciudad.provincia)
  }

  //devuelve Boolean
  override fun esInfluyente(): Boolean
  {
    return provinciasHabilitadas.sumBy { it.poblacion } >= 10000000
  }
}

class ComercioCorresponsal(val ciudades: List<Ciudad>) : Vendedor() {

  //devuelve Boolean
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return ciudades.contains(ciudad)
  }

  //devuelve Boolean
 override fun esInfluyente(): Boolean
  {
    return ciudades.size >= 5 || tieneAlMenosTresProvincias()
  }

  //devuelve Boolean
  fun tieneAlMenosTresProvincias() : Boolean
  {
    var tieneCiudades = mutableListOf<Ciudad>()

    for (ciudade in ciudades) {
      if ( !tieneCiudades.contains(ciudade) )
      {
        tieneCiudades.add(ciudade)
      }
    }
   return tieneCiudades.size > 3
  }
}
