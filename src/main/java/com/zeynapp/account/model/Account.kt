package com.zeynapp.account.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime

data class Account(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String?,
        val balance: BigDecimal?=BigDecimal.ZERO,
        val creationDate: LocalDateTime,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name = "customerId", nullable = false)
        val customer: Customer?,
        @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
        val transactions: Set<Transaction>?
){
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Account

                if (id != other.id) return false
                if (balance != other.balance) return false
                if (creationDate != other.creationDate) return false
                if (customer != other.customer) return false
                if (transactions != other.transactions) return false

                return true
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + (balance?.hashCode() ?: 0)
                result = 31 * result + creationDate.hashCode()
                return result
        }
}