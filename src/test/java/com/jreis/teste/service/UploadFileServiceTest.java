package com.jreis.teste.service;

import com.jreis.teste.domain.BcMsg;
import com.jreis.teste.domain.SisMsg;
import com.jreis.teste.repository.BcMsgRepository;
import com.jreis.teste.repository.SisMsgRepository;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
public class UploadFileServiceTest {

    @InjectMocks
    private UploadFileService uploadFileService;

    @Mock
    private BcMsgRepository bcMsgRepository;

    @Mock
    private SisMsgRepository sisMsgRepository;

    @Spy
    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void deveSalvarXml() throws IOException {
        String nomeArquivo = "test.xml";
        File arquivoXml = getArquivoXml(nomeArquivo);
        ArgumentCaptor<BcMsg> bcMsgCaptor = ArgumentCaptor.forClass(BcMsg.class);
        ArgumentCaptor<SisMsg> sisMsgCaptor = ArgumentCaptor.forClass(SisMsg.class);

        MultipartFile xmlFile = new MockMultipartFile(nomeArquivo, nomeArquivo, "xml", new FileInputStream(arquivoXml));
        uploadFileService.save(xmlFile);
        verify(bcMsgRepository).save(bcMsgCaptor.capture());
        verify(sisMsgRepository).save(sisMsgCaptor.capture());

        verify(bcMsgRepository, times(1)).save(any(BcMsg.class));
        verify(sisMsgRepository, times(1)).save(any(SisMsg.class));

        BcMsg bcMsg = bcMsgCaptor.getValue();
        SisMsg sisMsg = sisMsgCaptor.getValue();

        assertNotNull(bcMsg);
        assertFalse(bcMsg.getDomSist().isEmpty());
        assertNotNull(bcMsg.getGrupoSeqs());
        assertFalse(bcMsg.getGrupoSeqs().getNumSeq().isEmpty());

        assertNotNull(sisMsg);
        assertNotNull(sisMsg.getSlc0001());
        assertFalse(sisMsg.getSlc0001().getCodMsg().isEmpty());
        assertNotNull(sisMsg.getSlc0001().getGrupoSLC0001Liquid());
        assertNotNull(sisMsg.getSlc0001().getGrupoSLC0001Liquid().getGrupoSLC0001Prodt());
    }

    private File getArquivoXml(String nomeArquivo) throws IOException {
        String tempDir = System.getProperty("java.io.tmpdir");
        File file = ResourceUtils.getFile("classpath:test.xml");
        File copied = new File(tempDir.concat(nomeArquivo));
        FileUtils.copyFile(file, copied);
        copied.deleteOnExit();
        ;
        return copied;
    }

}
