package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		description("""""")
		method 'POST'
		url '/check'
		body(
				name:"Alex",
				age: 1
		)
		headers {
			contentType(applicationJson())
		}
	}
	response {
		status 200
		body("""
			{
				"message": "OK"
			}
			""")
		headers {
			contentType(applicationJson())
		}
	}
}
