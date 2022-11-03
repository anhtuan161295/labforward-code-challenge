import { act, fireEvent, render, screen } from '@testing-library/react';
import MainPage from '.';

test('when page loaded', () => {
  render(<MainPage />);
  const buttonElement = screen.getByText(/Apply/i);
  expect(buttonElement).toBeInTheDocument();
});

test('when user fills the text', () => {
  render(<MainPage />);
  const textElement = screen.getByTestId(/user-text/i);
  fireEvent.change(textElement, { target: { value: 'Good Day' } });
  expect(textElement).toBeVisible();
});

test('when user fills the keyword', () => {
  render(<MainPage />);
  const textElement = screen.getByTestId(/user-keyword/i);
  fireEvent.change(textElement, { target: { value: 'Good Day' } });
  expect(textElement).toBeVisible();
});

const mockData = { frequency: 2, similarWords: ['a', 'b'] };
global.fetch = () => Promise.resolve({ json: () => Promise.resolve(mockData) })

test('when user clicks Apple button', async () => {
  render(<MainPage />);
  // fill text
  const textElement1 = screen.getByTestId(/user-text/i);
  fireEvent.change(textElement1, { target: { value: 'Good Day' } });
  // fill keyword
  const textElement2 = screen.getByTestId(/user-keyword/i);
  fireEvent.change(textElement2, { target: { value: 'Good Day' } });

  await act(() => {
    // click button
    const buttonElement = screen.getByTestId(/apply-button/i);
    fireEvent.click(buttonElement);
    expect(buttonElement).toBeVisible();
  })
});
