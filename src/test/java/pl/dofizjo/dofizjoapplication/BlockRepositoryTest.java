package pl.dofizjo.dofizjoapplication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import pl.dofizjo.dofizjoapplication.data.BlockRepository;
import pl.dofizjo.dofizjoapplication.model.Block;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BlockRepositoryTest {

    @Autowired
    CacheManager cacheManager;

    @Autowired
    BlockRepository blockRepo;

    @BeforeEach
    public void setup() {
        blockRepo.add(new Block("header", "title", "content"));
        blockRepo.add(new Block("subheader", "title", "content"));
        blockRepo.add(new Block("menu", "title", "content"));
    }

    @AfterEach
    public void tearDown() {
        blockRepo.deleteAll();
        cacheManager.getCacheNames().forEach(name -> cacheManager.getCache(name).clear());
    }

    @Test
    public void whenSearchingAgainForSameBlockById_thenPulledFromCache() {
        // Given
        Block repositoryBlock = blockRepo.findById("header");

        // When
        Optional<Block> cachedBlock = Optional.ofNullable(cacheManager.getCache("blockCache").get("header", Block.class));

        // Then
        assertThat(repositoryBlock).isEqualTo(cachedBlock.get());
    }

    @Test
    public void whenOverwritingBlocks_thenBlockCacheEvicted() {
        // Given
        Block repositoryBlock = blockRepo.findById("header");

        // When
        blockRepo.overwrite(new Block("header", "title", "content"));

        // Then
        Optional<Block> nullResult = Optional.ofNullable(cacheManager.getCache("blockCache").get("header", Block.class));
        assertThat(nullResult.isPresent()).isEqualTo(false);
    }
}
