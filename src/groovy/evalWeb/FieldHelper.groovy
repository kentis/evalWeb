package evalWeb

import org.k1s.GrSexp.GrSexp

class FieldHelper{
	
	static def codeForSExp(sexp, idx){
		//println sexp
		def expr = new GrSexp().parse(sexp)[0]
		//println expr[0].text
		switch(expr[0].text){
			case "String":
				return "<input type=\"text\" name=\"bioField_${idx}\" value=\"\" />"
				break;
			case "select":
				def sb = new StringBuffer()
				sb.append("<select name=\"bioField_${idx}\">\n")
				
				expr[1].each{
					sb.append("<option value=\"${it.text}\">${it.text}</option>")
				}
				sb.append("</select>\n")
				return sb.toString()
				break

			default:
				throw new RuntimeException("unknown field operator: '${expr[0]}'")
		}
	}
	
	
}
