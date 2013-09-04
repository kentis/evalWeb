package evalWeb
class Experiment {
  String description
  String name
  boolean randomize
  String snippetsDir
  Bio bio
  static constraints = {
    description(nullable: true)
    description(unique: false)
    name(nullable: false)
    name(unique: false)
    randomize(nullable: true)
    randomize(unique: false)
    snippetsDir(nullable: true)
    snippetsDir(unique: false)
    bio(nullable: true)
    bio(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
