package cz.levinzonr.CopsBoot.domain.models.base

import java.io.Serializable
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntityId<T: Serializable>(
        private val id: T? = null
) : Serializable, EntityId<T>


