# Teste_Software_2025_Macedo_Br-cio_Santos_Henrick_Quentino_Jo-o_Souza_Maria_Freire_Pablo
Trabalho de Teste de Software 2025.1

# 🧪 Projeto de Teste Unitário com Maven

Este projeto tem como objetivo demonstrar a execução de testes unitários com Maven, abordando o seguinte problema encontrado no StackOverflow:

> **"Como executar apenas um método de teste específico com Maven?"**

---

## 🔍 Problema do StackOverflow

O autor do post sabia que poderia executar **todos os testes de uma classe** com o comando:

```bash
mvn test -Dtest=ClassName
```

Mas queria executar **apenas um método de teste**, como:

```bash
mvn test -Dtest=ClassName.methodName
```

Esse formato não funcionava corretamente, e gerava dúvidas comuns sobre como rodar testes individualmente com Maven.

---

## ✅ Solução Aceita

A forma correta de executar um **único método de teste** com Maven é:

```bash
mvn test -Dtest=NomeDaClasse#nomeDoMetodo
```

Exemplo:

```bash
mvn test -Dtest=TestCircle#testArea
```

> 💡 Esse formato foi introduzido no plugin `maven-surefire-plugin` a partir da versão `2.7.3`.

---

## 📁 Estrutura do Projeto

```
.
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── exemplo
    │               └── Circle.java
    └── test
        └── java
            └── com
                └── exemplo
                    └── TestCircle.java
```

### `Circle.java`
```java
package com.exemplo;

public class Circle {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}
```

### `TestCircle.java`
```java
package com.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCircle {

    @Test
    public void testArea() {
        Circle c = new Circle(2.0);
        assertEquals(Math.PI * 4, c.getArea(), 0.0001);
    }

    @Test
    public void testCircumference() {
        Circle c = new Circle(2.0);
        assertEquals(2 * Math.PI * 2, c.getCircumference(), 0.0001);
    }
}
```

---

Claro! Aqui está o `README` atualizado com instruções completas de **instalação e configuração do Maven** para **Windows e Linux (Ubuntu)**:

---

## ⚙️ Instalação e Configuração do Maven

### 🪟 Windows

#### 1. Baixe o Maven

* Acesse: [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
* Baixe a versão `.zip`
* Extraia em um local como: `C:\Program Files\Apache\Maven`

#### 2. Configure as variáveis de ambiente

* Abra o **Painel de Controle > Sistema > Configurações avançadas do sistema > Variáveis de Ambiente**
* Adicione:

  * `MAVEN_HOME`: `C:\Program Files\Apache\Maven`
  * Edite a variável `Path` e adicione: `C:\Program Files\Apache\Maven\bin`

> Após isso, **reinicie o terminal ou o VS Code**

#### 3. Teste a instalação:

```bash
mvn -v
```

Deve retornar a versão do Maven instalada.

---

### 🐧 Linux (Ubuntu 22.04)

#### 1. Baixe o Maven

* Acesse: [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
* Baixe o arquivo `.tar.gz`, por exemplo: `apache-maven-<versao>-bin.tar.gz`


#### 2. Extraia o arquivo

```bash
tar -xzf apache-maven-3.9.6-bin.tar.gz
sudo mv apache-maven-3.9.6 /opt/maven
```

#### 3. Configure as variáveis de ambiente

Adicione ao final do seu `~/.bashrc`, `~/.zshrc` ou `~/.profile`:

```bash
export MAVEN_HOME=/opt/maven
export PATH=$MAVEN_HOME/bin:$PATH
```

Depois, aplique as alterações:

```bash
source ~/.bashrc  # ou source ~/.zshrc
```

#### 4. Teste a instalação:

```bash
mvnd -v
```

Você deve ver a versão do Maven instalada.


---


---

## 🧪 Como Rodar os Testes

### Rodar todos os testes
#### mvn no windows, mvnd no linux
```bash
mvn test
```

### Rodar todos os testes de uma classe
```bash
mvn test -Dtest=TestCircle
```

### Rodar um método específico de teste
```bash
mvn test -Dtest=TestCircle#testArea
```

### Rodar vários métodos da mesma classe
```bash
mvn test -Dtest=TestCircle#testArea+testCircumference
```

---

## 💡 Observações

- O método deve estar anotado com `@Test`
- O nome da classe deve ser exatamente o mesmo do arquivo
- O plugin `maven-surefire-plugin` precisa estar atualizado (recomenda-se `>= 2.7.3`)

---

## 🧱 `pom.xml` usado

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.exemplo</groupId>
  <artifactId>circle-project</artifactId>
  <version>1.0-SNAPSHOT</version>

  <dependencies>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>5.10.0</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.0.0-M9</version>
      </plugin>
    </plugins>
  </build>
</project>
```

## 🎥 Link do Vídeo Tutorial

Assista ao tutorial gravado em vídeo sobre como executar testes específicos com Maven:

[Link para o Vídeo no YouTube](https://youtu.be/rr_CHZ628MI)
...
