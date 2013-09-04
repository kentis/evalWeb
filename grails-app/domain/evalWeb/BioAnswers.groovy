package evalWeb
class BioAnswers {
  Map answers
  static constraints = {
    answers(nullable: true)
    answers(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
