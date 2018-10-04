package cz.levinzonr.CopsBoot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CopsBootApplication

fun main(args: Array<String>) {
    runApplication<CopsBootApplication>(*args)
}
