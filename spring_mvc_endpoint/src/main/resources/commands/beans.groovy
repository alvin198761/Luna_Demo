package commands

import org.crsh.cli.Command
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext
import org.springframework.boot.actuate.endpoint.BeansEndpoint

class beans {

	@Usage("Display beans in ApplicationContext")
	@Command
	def main(InvocationContext context) {
		def result = [:]
		context.attributes['spring.beanfactory'].getBeansOfType(BeansEndpoint.class).each { name, endpoint ->
			result.put(name, endpoint.invoke())
		}
		result.size() == 1 ? result.values()[0] : result
	}

}