package cz.levinzonr.CopsBoot.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class ValueNotFoundException(msg: String) : RuntimeException(msg) {

}