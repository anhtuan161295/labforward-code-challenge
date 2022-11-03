import { render, screen } from '@testing-library/react';
import MainPage from '.';

test('when page loaded', () => {
  render(<MainPage />);
  const linkElement = screen.getByText(/Search/i);
  expect(linkElement).toBeInTheDocument();
});
