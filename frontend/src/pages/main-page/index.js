import { Button, Divider, Input, List } from 'antd';
import TextArea from 'antd/lib/input/TextArea';
import { useEffect, useState } from 'react';
import Footer from '../../layout/footer';
import Header from '../../layout/header';
import '../../style.css';

function MainPage() {
    const [frequency, setFrequency] = useState(0);
    const [searchResults, setSearchResults] = useState([]);
    const [similarWordCount, setSimilarWordCount] = useState(0);
    const [searchResultVisible, setSearchResultVisible] = useState(false);
    const [text, setText] = useState('');
    const [keyword, setKeyword] = useState('');

    const onSearchButtonClick = () => {
        fetch("http://localhost:8080/api/word-frequency", {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                'text': text,
                'keyword': keyword
            })

        })
            .then(res => res.json())
            .then((result) => {
                console.log(result);
                setSearchResults(result.similarWords);
                setFrequency(result.frequency);
            });
    };

    const onTextChange = (e) => {
        setText(e.target.value);
    }

    const onKeywordChange = (e) => {
        setKeyword(e.target.value);
    }

    useEffect(() => {
        setSearchResultVisible(searchResults.length > 0);
        setSimilarWordCount(searchResults.length);
    }, [searchResults]);

    return (
        <div className="main-page">
            <Header />
            <div className='body-container'>
                <div style={{ fontWeight: 'bold' }}>Search</div>
                <div style={{ fontSize: 12 }}>Find details in notebook</div>
                <Divider />
                <div>Enter the text</div>
                <TextArea
                    data-testid='user-text'
                    allowClear
                    rows={4}
                    style={{ width: '400px' }}
                    onChange={onTextChange}
                    maxLength={250}
                />
                <div style={{ fontSize: 12 }}>Max characters is 250</div>
                <Divider />
                <div>Enter the keywords</div>
                <Input
                    data-testid='user-keyword'
                    allowClear
                    onChange={onKeywordChange}
                    maxLength={50}
                    style={{
                        width: 200,
                    }}
                />
                <div style={{ fontSize: 12 }}>Max characters is 50</div>
                <Divider />
                <Button type="primary"
                    data-testid='apply-button'
                    onClick={onSearchButtonClick}
                >Apply</Button>
                <Divider />
                <div style={{ fontWeight: 'bold' }}>Search Results</div>
                <div style={{ display: 'flex', flexDirection: 'row' }}>
                    <div>Frequency: {frequency}</div>
                    &nbsp; | &nbsp;
                    <div>Similar words: {similarWordCount}</div>
                </div>
                <Divider />
                <List
                    style={{ visibility: searchResultVisible ? 'visible' : 'hidden' }}
                    bordered
                    dataSource={searchResults}
                    renderItem={item => (
                        <List.Item style={{ display: 'flex', justifyContent: 'center' }}>
                            {item}
                        </List.Item>
                    )}
                    pagination={{
                        pageSize: 1,
                        total: searchResults.length,
                    }}
                />
            </div>

            <Footer />
        </div>
    );
}

export default MainPage;
