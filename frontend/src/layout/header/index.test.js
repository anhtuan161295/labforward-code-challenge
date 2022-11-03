import { render, screen } from '@testing-library/react';
import Header from '.';

test('test header', () => {
  render(<Header />);
  const linkElement = screen.getByText(/labforward/i);
  expect(linkElement).toBeInTheDocument();
});
