def value = 5
def result = 0
value.times {
    println it
    result += it
}
println result

String basePath = "D:/file_teste";
def directory = new File(basePath)
if(!directory.exists()){
    println "Diretório $directory.path, criado com sucesso"
    directory.mkdir()
}
// Criar arquivo
def file = new File("$basePath/file.txt")
// Adicionar texto
file.text = "Linha 1"
// Adicionar 3 linhas de texto
3.times {file << "\r\nnova linha usando sobrecarga de operador" }
// Exibi as informações do arquivo
println file.text

// Deletando um diretório específico
if (directory.exists()) {
    println "Diretório $directory.path apagado"
    directory.deleteDir()
}