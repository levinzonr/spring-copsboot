package cz.levinzonr.CopsBoot.domain.models.base

import java.io.Serializable
import java.time.Year

interface EntityId<T>  : Serializable {

    fun getId() : T
    fun asString() : String
}