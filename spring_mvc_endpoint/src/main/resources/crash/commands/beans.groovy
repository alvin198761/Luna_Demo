package crash.commands

import org.crsh.cli.Command
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext
import org.springframework.boot.actuate.endpoint.BeansEndpoint

class beans {

	@Usage("Display beans in ApplicationContext")
	@Command
	def main(InvocationContext context) {
		def result = [:]
		context.attributes['factory'].getBeansOfType(BeansEndpoint.class).each { name, endpoint ->
			result.put(name, endpoint.invoke())
		}
		out.println result
	}

}