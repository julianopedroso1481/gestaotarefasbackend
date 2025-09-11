INSERT INTO PROJETO (NOME) VALUES ('DATAPREV');
INSERT INTO PROJETO (NOME) VALUES ('INSS');
INSERT INTO PROJETO (NOME) VALUES ('MEC');
INSERT INTO PROJETO (NOME) VALUES ('PREVIDENCIA');
INSERT INTO PROJETO (NOME) VALUES ('GOV');
INSERT INTO PROJETO (NOME) VALUES ('IBGE');
INSERT INTO PROJETO (NOME) VALUES ('CORREIOS');
INSERT INTO PROJETO (NOME) VALUES ('UTFPR');
INSERT INTO PROJETO (NOME) VALUES ('RFBH');
INSERT INTO PROJETO (NOME) VALUES ('RFMT');
INSERT INTO PROJETO (NOME) VALUES ('RFMG');
INSERT INTO PROJETO (NOME) VALUES ('RFPR');
INSERT INTO PROJETO (NOME) VALUES ('PF');
INSERT INTO PROJETO (NOME) VALUES ('GOV');


INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Processamento em Lote de PIX', 'Atividade de criação de leitura dos arquivos do DataPrev para processamento em lotes do Sistema de PIX.','EM PROGRESSO' FROM PROJETO WHERE UPPER(NOME) = UPPER('DATAPREV');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Processamento de PIX', 'Atividade de criação das classes de processamento dos arquivos para os arquivos em lote do Sistemas de PIX.','ABERTA' FROM PROJETO WHERE UPPER(NOME) = UPPER('DATAPREV');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Processamento de PIX salvando na base', 'Atividade de criação das classes para salvar na base após o processamento do sistema PIX.','CONCLUÍDA' FROM PROJETO WHERE UPPER(NOME) = UPPER('DATAPREV');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Processamento de PIX salvando os Erros', 'Atividade de criação de classes para tratar os erros dos processamentos não finalizados do Sistema PIX do processamento em lote.','EM PROGRESSO' FROM PROJETO WHERE UPPER(NOME) = UPPER('DATAPREV');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Disponibilização de endpoint para consulta de dados pessoais pelo CPF ou CNPJ', 'Criação de API Monolitica para consulta de dados do cliente pelo CPF ou CNPJ.','ABERTA' FROM PROJETO WHERE UPPER(NOME) = UPPER('INSS');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Disponibilização de endpoint para consulta transações pelo CPF ou CNPJ e Data', 'Criação de API Monolitica para consulta de dados de transações do cliente pelo CPF ou CNPJ e Data.','EM PROGRESSO' FROM PROJETO WHERE UPPER(NOME) = UPPER('INSS');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Alteração de Procedure para o MEC','Alteração de Procedure para envio de relatório para o MEC.','EM PROGRESSO' FROM PROJETO WHERE UPPER(NOME) = UPPER('MEC');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Criação de Workflow para Previdencia','Criação de Workflow para o Sistema de previdência.','CONCLUÍDO' FROM PROJETO WHERE UPPER(NOME) = UPPER('PREVIDENCIA');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Criação de integração de Assinatura Digital para Previdencia','Criação da integração com o cartório para assinatura digital de documentos, para o workflow do Sistema de Previdência.','ABERTO' FROM PROJETO WHERE UPPER(NOME) = UPPER('PREVIDENCIA');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Criação de Sistema GED para Previdencia','Criação da Arquitetura do Sistema GED para uso do Sistema de Previdência.','CONCLUÍDO' FROM PROJETO WHERE UPPER(NOME) = UPPER('PREVIDENCIA');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Desenvolvimento do Sistema GED para Previdencia','Desenvolvimento das classes de modelo de banco do Sistema GED para uso do Sistema de Previdência.','ABERTA' FROM PROJETO WHERE UPPER(NOME) = UPPER('PREVIDENCIA');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Desenvolvimento end points do Sistema GED para o sistema GOV','Desenvolvimento dos endpoints para acesso do sistema GOV.','ABERTA' FROM PROJETO WHERE UPPER(NOME) = UPPER('GOV');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Desenvolvimento end points do Sistema GED para o sistema MEC','Desenvolvimento dos endpoints para acesso do sistema MEC.','ABERTA' FROM PROJETO WHERE UPPER(NOME) = UPPER('MEC');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Desenvolvimento end points do Sistema GED para o sistema IBGE','Desenvolvimento dos endpoints para acesso do sistema IBGE.','ABERTA' FROM PROJETO WHERE UPPER(NOME) = UPPER('IBGE');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Desenvolvimento end points do Sistema GED para o sistema CORREIOS','Desenvolvimento dos endpoints para acesso do sistema CORREIOS.','ABERTA' FROM PROJETO WHERE UPPER(NOME) = UPPER('CORREIOS');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Desenvolvimento end points do Sistema GED para o sistema RFPR','Desenvolvimento dos endpoints para acesso do sistema RFPR.','ABERTA' FROM PROJETO WHERE UPPER(NOME) = UPPER('RFPR');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Desenvolvimento end points do Sistema GED para o sistema PF','Desenvolvimento dos endpoints para acesso do sistema PF.','ABERTA' FROM PROJETO WHERE UPPER(NOME) = UPPER('PF');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Desenvolvimento end points do Sistema GED para o sistema RFMG','Desenvolvimento dos endpoints para acesso do sistema RFMG.','ABERTA' FROM PROJETO WHERE UPPER(NOME) = UPPER('RFMG');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Desenvolvimento end points do Sistema GED para o sistema RFMT','Desenvolvimento dos endpoints para acesso do sistema RFMT.','ABERTA' FROM PROJETO WHERE UPPER(NOME) = UPPER('RFMT');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Desenvolvimento end points do Sistema GED para o sistema IBGE','Desenvolvimento dos endpoints para acesso do sistema RFBH.','ABERTA' FROM PROJETO WHERE UPPER(NOME) = UPPER('RFBH');
INSERT INTO TAREFA (ID_PROJETO,DATA_CRIACAO,TITULO, DESCRICAO, STATUS) 
SELECT ID_PROJETO, CURRENT_DATE,'Desenvolvimento end points do Sistema GED para o sistema da UTFPR','Desenvolvimento dos endpoints para acesso do sistema RFBH.','ABERTA' FROM PROJETO WHERE UPPER(NOME) = UPPER('UTFPR');