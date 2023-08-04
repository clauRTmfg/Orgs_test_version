package br.com.alura.orgs

import br.com.alura.orgs.model.Produto
import org.amshove.kluent.shouldBeFalse
import org.amshove.kluent.shouldBeTrue
import org.junit.Test
import java.math.BigDecimal

class ProdutoTestes {

    @Test
    fun `DEVE retornar verdadeiro QUANDO o valor for valido`() {
        val produtoValido = Produto(
            nome = "Banana",
            descricao = "Banana prata",
            valor = BigDecimal("6.99")
        )

        val valorEhValido = produtoValido.valorValido

        // usando JUnit
        //assertTrue(valorEhValido)

        // usando Kluent
        //valorEhValido shouldBeEqualTo true
        valorEhValido.shouldBeTrue()
    }

    @Test
    fun `DEVE retornar falso QUANDO o valor for maior que cem reais`() {
        //Arrange - Arrumar
        val produtoInvalido = Produto(
            nome = "Carambola",
            descricao = "Amarela",
            valor = BigDecimal("105.99")
        )

        //Act - Agir
        val valorEhValido = produtoInvalido.valorValido

        //Assert - Afirme
        //JUnit
        //assertFalse(valorEhValido)

        valorEhValido.shouldBeFalse()
    }

    @Test
    fun `DEVE retornar falso QUANDO o valor for menor ou igual a zero`() {
        val produtoComValorIgualAZero = Produto(
            nome = "Lichia",
            descricao = "Doce",
            valor = BigDecimal("0")
        )
        val produtoComValorMenorQueZero = Produto(
            nome = "Uva",
            descricao = "Thompson",
            valor = BigDecimal("-10.99")
        )

        val valorIgualAZeroEhValido = produtoComValorIgualAZero.valorValido
        val valorMenorQueZeroEhValido = produtoComValorMenorQueZero.valorValido

        valorIgualAZeroEhValido.shouldBeFalse()
        valorMenorQueZeroEhValido.shouldBeFalse()
    }
}