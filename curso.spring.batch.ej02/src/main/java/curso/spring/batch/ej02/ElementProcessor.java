package curso.spring.batch.ej02;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import curso.spring.batch.ej02.model.AnotherElement;
import curso.spring.batch.ej02.model.Element;

@Component
public class ElementProcessor implements ItemProcessor<Element, AnotherElement> {
 
    @Override
    public AnotherElement process(Element element) throws Exception {
        final String anotherElementId = element.getId() + "::" + element.getText();
        return new AnotherElement(anotherElementId);
    }
}