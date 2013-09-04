package evalWeb
class Participation {
  Map answers
  Date startTime
  Date stopTime
  Map answersTimes
  Date firstSnippetStart
  Experiment experiment
  BioAnswers bioAnswers
  static constraints = {
    answers(nullable: true)
    answers(unique: false)
    startTime(nullable: true)
    startTime(unique: false)
    stopTime(nullable: true)
    stopTime(unique: false)
    answersTimes(nullable: true)
    answersTimes(unique: false)
    firstSnippetStart(nullable: true)
    firstSnippetStart(unique: false)
    experiment(nullable: true)
    experiment(unique: false)
    bioAnswers(nullable: true)
    bioAnswers(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
