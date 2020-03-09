package com.jreis.teste.service;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jreis.teste.controller.UploadFileController;
import com.jreis.teste.domain.BcMsg;
import com.jreis.teste.domain.GrupoSeq;
import com.jreis.teste.domain.SisMsg;
import com.jreis.teste.repository.BcMsgRepository;
import com.jreis.teste.repository.SisMsgRepository;
import com.jreis.teste.request.SlcRequest;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

import static com.jreis.teste.helper.Common.multipartToFile;
import static com.jreis.teste.helper.Common.readLineByLineJava8;
import static com.jreis.teste.helper.GenericJAXBTools.unmarshallFromXMLToObject;

@Service
@Slf4j
public class UploadFileService {

    private static final Logger logger = LoggerFactory.getLogger(UploadFileController.class);
    @Autowired
    private BcMsgRepository bcMsgRepository;
    @Autowired
    private SisMsgRepository sisMsgRepository;
    @Autowired
    private ModelMapper modelMapper;

    public void save(MultipartFile multipartFile) {
        try {
            File file = multipartToFile(multipartFile, multipartFile.getOriginalFilename());
            JacksonXmlModule module = new JacksonXmlModule();
            module.setDefaultUseWrapper(false);
            XmlMapper xmlMapper = new XmlMapper(module);

            SlcRequest slcRequest = xmlMapper.readValue(file, SlcRequest.class);
            BcMsg bcMsg = modelMapper.map(slcRequest.getBcMsg(), BcMsg.class);
            SisMsg sisMsg = modelMapper.map(slcRequest.getSisMsg(), SisMsg.class);
//TODO: INSPECIONAR sisMsg não está recebendo atribuições corretas de seus respectivos campos.
// Consequentemente não salva todos os campos filhos da árvore do documento.
            bcMsgRepository.save(bcMsg);
            sisMsgRepository.save(sisMsg);

        } catch (IOException e) {
            log.error("Erro na conversão do arquivo xml - {}: {}", multipartFile.getName(), e.getLocalizedMessage());
        }

    }

    //save file
    public void saveUploadedFile(MultipartFile file) throws IOException {

        if (file.isEmpty())
            return;

        try {
            File fileOK = multipartToFile(file, file.getOriginalFilename());

            String arquivoStr = readLineByLineJava8(fileOK.getPath());

            try {

                Document doc = Jsoup.parse(arquivoStr, "", Parser.xmlParser());
                // TODO: PERSISTÊNCIA
                //  TODO: FAZER A CAMADA SERVICES P ISSO
                for (Element e : doc.select("BCMSG")) {
                    BcMsg bcMsg = new BcMsg();
                    for (Element element : doc.select("IdentdEmissor")) {
                        bcMsg.setIdentdEmissor(element.child(0).toString());  //TODO: verificando
                    }
                    System.out.println(e);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            GrupoSeq grupoSeqDoArquivo = unmarshallFromXMLToObject(GrupoSeq.class, readLineByLineJava8(fileOK.getPath()));

            JsonObject jsonObject = new JsonParser().parse(grupoSeqDoArquivo.toJson()).getAsJsonObject();
            System.out.println(jsonObject);

        } catch (
                JAXBException e) {
            e.printStackTrace();
        }

    }

/*    public void save(final GrupoSeq grupoSeq) {
        grupoSeqRepository.save(grupoSeq);
    }

    public void update(Long id, GrupoSeq grupoSeq) {
        GrupoSeq grupoSeqOld = findById(id);
        grupoSeq.setId(grupoSeqOld.getId());

        grupoSeqRepository.save(grupoSeq);
    }*/

}