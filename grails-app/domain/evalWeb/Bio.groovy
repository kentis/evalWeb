package evalWeb
class Bio {
  static constraints = {
    fields(nullable: true)
    fields(unique: false)
  }
  static hasMany = [fields:BioField]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
