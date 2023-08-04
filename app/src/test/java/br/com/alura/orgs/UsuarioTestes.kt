package br.com.alura.orgs

import br.com.alura.orgs.model.Usuario
import org.amshove.kluent.shouldBeFalse
import org.amshove.kluent.shouldBeTrue
import org.junit.Assert.*
import org.junit.Test

class UsuarioTestes {

    @Test
    fun `DEVE retornar verdadeiro QUANDO o novo usuario for valido`() {

        val usuarioValido = Usuario(
            id = "clau",
            email = "clau@gmail.com",
            senha = "qwerty"
        )

        val usuarioEhValido = usuarioValido.ehValido()


        // usando JUnit
        //Assert.assertEquals(true, usuarioEhValido)
        //assertTrue(usuarioEhValido)

        // usando Kluent
        //usuarioEhValido shouldBeEqualTo true
        usuarioEhValido.shouldBeTrue()
    }

    @Test
    fun `DEVE retornar falso QUANDO o email do novo usuario for invalido`() {

        // Arrange
        val usuarioEmailInvalido = Usuario(
            id = "clau",
            email = "clau@gmail",
            senha = "qwerty"
        )

        // Act
        val usuarioEhValido = usuarioEmailInvalido.ehValido()

        // Assert
        usuarioEhValido.shouldBeFalse()
    }

    @Test
    fun `DEVE retornar falso QUANDO a senha do novo usuario for menor que 6 caracteres`() {

        val usuarioSenhaCurta = Usuario(
            id = "clau",
            email = "clau@gmail.com",
            senha = "1234"
        )

        val usuarioEhValido = usuarioSenhaCurta.ehValido()

        usuarioEhValido.shouldBeFalse()
    }

}