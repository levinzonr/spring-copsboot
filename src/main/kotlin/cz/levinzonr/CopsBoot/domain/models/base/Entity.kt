package cz.levinzonr.CopsBoot.domain.models.base

interface Entity<T: EntityId<T>> {
    fun getId() : T
}