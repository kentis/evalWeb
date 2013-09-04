package evalWeb
class BioField {
  String name
  String type
  int sortAs
  static constraints = {
    name(nullable: true)
    name(unique: false)
    type(nullable: true)
    type(unique: false)
    sortAs(nullable: true)
    sortAs(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
